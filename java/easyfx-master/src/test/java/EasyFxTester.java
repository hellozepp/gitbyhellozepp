import com.hello.zepp.EasyFX;
import com.hello.zepp.entity.Operator;
import com.hello.zepp.utils.TaylorSeries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * java -cp easyfx-master.jar EasyFxTester
 * Created by docker on 2017/10/23.
 */
public class EasyFxTester {
    private static Logger log = LoggerFactory.getLogger(EasyFxTester.class);

    public static void main(String[] args) {
        EasyFX easyFX = new EasyFX();
        Operator op1 = new Operator() {
            public double call() {
                TaylorSeries taylorSeries = new TaylorSeries();
                taylorSeries.eSeriesApproximation(.5);//e^1/2=1.6487212707
                log.info("the op1 is finish,res is :" + taylorSeries.getApproximationDouble());
                while (true);//轮转测试
//                return (taylorSeries.getApproximationDouble());
            }
        };
        Operator op2 = new Operator() {
            public double call() {
                TaylorSeries taylorSeries = new TaylorSeries();
                double sin = taylorSeries.sin(0.5 * Math.PI);
                TaylorSeries taylorSeries1 = new TaylorSeries();
                taylorSeries1.eSeriesApproximation(.5);
                double approximationDouble = taylorSeries1.getApproximationDouble();
                double multiply = sin + approximationDouble;
                log.info("the op2 is finish,res is :" + multiply);
                while (true);
//                return multiply;
            }
        };
        Operator op3 = new Operator() {
            public double call() {
                TaylorSeries taylorSeries = new TaylorSeries();
                double sin = taylorSeries.sin(0.5 * Math.PI);
                TaylorSeries taylorSeries1 = new TaylorSeries();
                taylorSeries1.eSeriesApproximation(.5);
                double approximationDouble = taylorSeries1.getApproximationDouble();
                double multiply = sin + approximationDouble;
                log.info("the op2 is finish,res is :" + multiply);
                while (true);
//                return multiply;
            }
        };
        Operator op4 = new Operator() {
            public double call() {
                TaylorSeries taylorSeries = new TaylorSeries();
                double sin = taylorSeries.sin(0.5 * Math.PI);
                TaylorSeries taylorSeries1 = new TaylorSeries();
                taylorSeries1.eSeriesApproximation(.5);
                double approximationDouble = taylorSeries1.getApproximationDouble();
                double multiply = sin + approximationDouble;
                log.info("the op2 is finish,res is :" + multiply);
                while (true);
//                return multiply;
            }
        };
        Operator op5 = new Operator() {
            public double call() {
                TaylorSeries taylorSeries = new TaylorSeries();
                double sin = taylorSeries.sin(0.5 * Math.PI);
                TaylorSeries taylorSeries1 = new TaylorSeries();
                taylorSeries1.eSeriesApproximation(.5);
                double approximationDouble = taylorSeries1.getApproximationDouble();
                double multiply = sin + approximationDouble;
                log.info("the op2 is finish,res is :" + multiply);
                while (true);
//                return multiply;
            }
        };
//        TaylorSeries.setArithmetic(MyTaylorSeries.class);//自定义算法
        easyFX.setParallelNu(7).setOps(op1, op2,op3,op4,op5).execute();
        double multiply = Math.sqrt(op1.val + op2.val*(op1.val+1)/2+op3.val+op4.val+op5.val);
        System.out.println("结果为：" + multiply);
    }

}
