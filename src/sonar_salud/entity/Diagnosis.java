package sonar_salud.entity;

public class Diagnosis {
    private String symptoms;
    private String diseases;
    private String diagnostic;
    private String treatment;


    public Diagnosis(String symptoms, String diseases, String diagnostic, String treatment) {
        this.symptoms = symptoms;
        this.diseases = diseases;
        this.diagnostic = diagnostic;
        this.treatment = treatment;
    }
    
    

    public Diagnosis() {
		super();
	}



	public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiseases() {
        return diseases;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }



	@Override
	public String toString() {
		return "Diagnosis [symptoms=" + symptoms + ", diseases=" + diseases + ", diagnostic=" + diagnostic
				+ ", treatment=" + treatment + "]";
	}
    
    
}
