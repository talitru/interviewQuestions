package il.co.ilrd.InterviewQuestions;

public class ExpressionTree {

    public double calc(OperatorNode root) {
        return root.calc();
    }

    private interface ETNode {
        public double calc();
    }

    private interface Operator{
        public double evaluate(double num1, double num2);
    }
    private static class Plus implements Operator{
        @Override
        public double evaluate(double num1, double num2) {
            return num1 + num2;
        }
    }
    private static class Minus implements Operator{
        @Override
        public double evaluate(double num1, double num2) {
            return num1 - num2;
        }
    }
    private static class Div implements Operator{
        @Override
        public double evaluate(double num1, double num2) {
            return num1 / num2;
        }
    }
    private static class Multi implements Operator{
        @Override
        public double evaluate(double num1, double num2) {
            return num1 * num2;
        }
    }

    static class OperatorNode implements ETNode {
        private Operator operator;
        private ETNode left;
        private ETNode right;

        public OperatorNode(ETNode right, ETNode left, Operator operator) {
            this.operator = operator;
            this.left = left;
            this.right = right;
        }

        @Override
        public double calc() {
            return operator.evaluate(left.calc(), right.calc());
        }

        static class LeafOperand implements ETNode {
            private String operand;

            public LeafOperand(String value) {
                operand = value;
            }
            @Override
            public double calc() {
                return Integer.valueOf(operand);
            }
        }

        public static void main(String[] args) {
            ExpressionTree expressionTree = new ExpressionTree();
            Plus plus = new Plus();
            Minus minus = new Minus();
            Multi multi = new Multi();
            Div div = new Div();

            LeafOperand num3 = new LeafOperand("5");
            LeafOperand num4 = new LeafOperand("9");

            OperatorNode op3 = new OperatorNode(num3, num4, plus);
            LeafOperand num2 = new LeafOperand("2");
            LeafOperand num1 = new LeafOperand("3");
            OperatorNode op2 = new OperatorNode(op3, num2, multi);
            OperatorNode op1 = new OperatorNode(num1, op2, plus);

            // 31 should be printed
            System.out.println(expressionTree.calc(op1));
        }
    }
}
