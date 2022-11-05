package Planes;

import models.ClassificationLevel;
import models.ExperimentalType;

public class ExperimentalPlane extends Plane{
    private ClassificationLevel classificationLevel;
    private final ExperimentalType experimentalType;
    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalType experimentalType, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.classificationLevel = classificationLevel;
        this.experimentalType = experimentalType;
    }

    public ClassificationLevel getClassificationLevel(){
        return classificationLevel;
    }
    public ExperimentalType getExperimentalType(){
        return experimentalType;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel){
        this.classificationLevel = classificationLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ExperimentalPlane)) return false;
        return super.equals(o) && classificationLevel == ((ExperimentalPlane) o).classificationLevel;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", classificationLevel=" + classificationLevel +
                        '}');
    }
}