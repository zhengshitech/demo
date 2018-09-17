package tech.zhengshi.webutils.monitor;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @author H
 */
@Aspect
@Component
public class TimeMeter {



    @Around("methodsToBeMonitor()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        String id = pjp.getSignature().toLongString();
        MethodInfo currentMethod = new MethodInfo();
        currentMethod.setName(id);
        Stack<MethodInfo> stack = methodInvokeStack.get();
        if (null == stack || stack.size() == 0) {
            stack = new Stack<>();
            currentMethod.setInvokeLevel(ROOT_METHOD);
            stack.push(currentMethod);
            methodInvokeStack.set(stack);
        } else {
            MethodInfo parent = stack.peek();
            currentMethod.setInvokeLevel(parent.getInvokeLevel() + 1);
            currentMethod.setParent(parent);
            stack.push(currentMethod);
        }
        StopWatch sw = new StopWatch(id);
        try {
            sw.start(pjp.getSignature().getName());
            return pjp.proceed();
        } finally {
            sw.stop();
            MethodInfo completeMethod = stack.pop();
            completeMethod.setTime(sw.getTotalTimeMillis());
            if (completeMethod.getInvokeLevel() >= ROOT_METHOD) {
                Stack<MethodInfo> outputStack = reverseMethodInvokeStack.get();
                if (null == outputStack) {
                    outputStack = new Stack<>();
                    reverseMethodInvokeStack.set(outputStack);
                }
                outputStack.push(completeMethod);
            }

            if (completeMethod.getInvokeLevel() == ROOT_METHOD) {
                prettyPrint();
            }

        }
    }

    private void prettyPrint() {

        List<MethodInfo> outputStack = getMethodOrderedInvoke();
        if (null == outputStack || outputStack.size() == 0) {
            return;
        }

        splitLine();
        for (MethodInfo info : outputStack) {
            int level = info.getInvokeLevel() + 1;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < level; i++) {
                if (info.getInvokeLevel() == ROOT_METHOD) {
                    sb.append("    ");
                } else if (i == level - 1) {
                    sb.append(" \\---");
                } else {
                    sb.append("    ");
                }
            }
            sb.append(info.pretty());
            System.out.println(sb);
        }
        splitLine();
        cleanReverseMethodInvokeStack();
        System.out.println("");
    }


    private List<MethodInfo> getMethodOrderedInvoke() {
        Stack<MethodInfo> methods = reverseMethodInvokeStack.get();
        if (null == methods) {
            return null;
        }
        List<MethodInfo> orderedData = new LinkedList<>();
        MethodInfo root = methods.pop();
        orderedData.add(root);
        addToOrder(root, methods, orderedData);
        return orderedData;
    }

    private void addToOrder(MethodInfo parentMethod, Stack<MethodInfo> methods, List<MethodInfo> orderedData) {
        int targetLevel = parentMethod.getInvokeLevel() + 1;
        for (MethodInfo method : methods) {
            if (method.getInvokeLevel() == targetLevel && Objects.equals(method.getParent().getName(), parentMethod.getName())) {
                orderedData.add(method);
                addToOrder(method, methods, orderedData);
            }
        }
    }

    private void cleanReverseMethodInvokeStack() {
        Stack<MethodInfo> stack = reverseMethodInvokeStack.get();
        if (null != stack) {
            while (!stack.empty()) {
                stack.pop();
            }
        }
    }

    private void splitLine() {
        System.out.println("==================================================================================================================================================================");
    }


    /**
     * 方法切入点
     */

    @Pointcut("execution(public * tech.zhengshi..*.*(..))")
    public void methodsToBeMonitor() {
    }


    /**
     * 方法信息对象
     */

    class MethodInfo {

        //名称
        private String name;
        //方法时间
        private Long time;

        //调用层级
        private Integer invokeLevel;

        private MethodInfo parent;

        public MethodInfo getParent() {
            return parent;
        }

        public void setParent(MethodInfo parent) {
            this.parent = parent;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getTime() {
            return time;
        }

        public void setTime(Long time) {
            this.time = time;
        }

        public Integer getInvokeLevel() {
            return invokeLevel;
        }

        public void setInvokeLevel(Integer invokeLevel) {
            this.invokeLevel = invokeLevel;
        }

        String pretty() {
            return "[" + this.time + "ms]" + this.name;
        }

    }


}
