import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.converters.DatabaseLoader;

public class TestWeka {
    public static void main(String[] args) throws Exception {
        DatabaseLoader loader = new DatabaseLoader();
        loader.setSource("jdbc:mysql://localhost:3306/stu?serverTimezone=UTC&characterEncoding=UTF8", "root", "031209");
        loader.connectToDatabase();
        loader.setQuery("select * from user");
        Instances instance = loader.getDataSet();
        instance.setClassIndex(instance.numAttributes() - 1);
        System.out.println(instance.numAttributes());
        Classifier classifier = (Classifier) Class.forName("com.stu.entity.User").newInstance();
        classifier.buildClassifier(instance);
        Evaluation evaluation = new Evaluation(instance);
        evaluation.evaluateModel(classifier, instance);
        System.out.println(evaluation.errorRate());

    }
}
