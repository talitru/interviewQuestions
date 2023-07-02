package il.co.ilrd.InterviewQuestions;

import java.util.HashMap;

public class CalculatorQuiz {
    private HashMap<String, Operator> map = new HashMap<>();

    public CalculatorQuiz() {
        addOpToMap("+", (a, b)->a+b);
        addOpToMap("-", Subtraction);
        addOpToMap("*", new Multi());

        //Division (using local class

      Operator Subtraction = new Operator() {
            public double operate(double a, double b) {
                return a - b;
            }
        };

        class Division implements Operator {
            @Override
            public double operate(double a, double b) {
                return a / b;
            }
        }
        addOpToMap("/", new Division());
    }


    //Subtraction- using anonymous class
    Operator Subtraction = new Operator() {
        public double operate(double a, double b) {
            return a - b;
        }
    };

    // Multiplication- using inner class
    private class Multi implements Operator {
        @Override
        public double operate(double a, double b) {
            return a * b;
        }
    }
    public void addOpToMap(String key, Operator o){
        map.put(key, o);
    }
    public double calculate(String key, double a, double b) {
        return map.get(key).operate(a, b);
    }

    private interface Operator {
        double operate(double a, double b);
    }

    public static void main(String[] args) {
        CalculatorQuiz calc = new CalculatorQuiz();

        System.out.println(calc.calculate("+", 5, 3));
        System.out.println(calc.calculate("-", 5, 3));
        System.out.println(calc.calculate("*", 5, 3));
        System.out.println(calc.calculate("/", 9, 3));
    }
}


            /*int lineNumber = 0;

            try (BufferedReader fileReader = new BufferedReader(new FileReader(path));
                 BufferedReader backupReader = new BufferedReader(new FileReader(backupPath))) {
                String fileLine = fileReader.readLine();
                String backupLine = backupReader.readLine();
                while ((fileLine != null) && (backupLine != null)) {
                    if (!fileLine.equals(backupLine)) {
                        fileCRUD.update(lineNumber++, fileLine);
                    }
                    fileLine = fileReader.readLine();
                    backupLine = backupReader.readLine();
                }

                while (fileLine != null) {
                    fileCRUD.create(fileLine);
                    fileLine = fileReader.readLine();
                }

                while (backupLine != null) {
                    fileCRUD.delete(lineNumber++);
                    backupLine = backupReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }*/
