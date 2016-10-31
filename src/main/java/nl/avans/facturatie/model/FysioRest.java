package nl.avans.facturatie.model;

public class FysioRest {

    private String dateObject;
    private String status;
    private String physiotherapistName;
    private String date;
    private String patientId;
    private String patientName;
    private String treatmentName;
    private String appointmentId;
    private String treatmentCode;
    private String treatmentTime;

    public FysioRest() {
    }

    public FysioRest(String dateObject, String status, String physiotherapistName, String date, String patientId, String patientName, String treatmentName, String appointmentId, String treatmentCode, String treatmentTime) {
        this.dateObject = dateObject;
        this.status = status;
        this.physiotherapistName = physiotherapistName;
        this.date = date;
        this.patientId = patientId;
        this.patientName = patientName;
        this.treatmentName = treatmentName;
        this.appointmentId = appointmentId;
        this.treatmentCode = treatmentCode;
        this.treatmentTime = treatmentTime;
    }

    public String getDateObject() {
        return dateObject;
    }

    public void setDateObject(String dateObject) {
        this.dateObject = dateObject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhysiotherapist() {
        return physiotherapistName;
    }

    public void setPhysiotherapist(String physiotherapistName) {
        this.physiotherapistName = physiotherapistName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getTreatmentCode() {
        return treatmentCode;
    }

    public void setTreatmentCode(String treatmentCode) {
        this.treatmentCode = treatmentCode;
    }

    public String getTreatmentTime() {
        return treatmentTime;
    }

    public void setTreatmentTime(String treatmentTime) {
        this.treatmentTime = treatmentTime;
    }

    @Override
    public String toString() {
        return "ClassFysioRest [dateObject = " + dateObject + ", status = " + status
                + ", physiotherapistName = " + physiotherapistName + ", date = " + date
                + ", patientId = " + patientId + ", patientName = " + patientName + ", treatmentName = " + treatmentName + ", appointmentId = "
                + appointmentId + ", treatmentCode = " + treatmentCode + ", treatmentTime = " + treatmentTime + "]";
    }
}
