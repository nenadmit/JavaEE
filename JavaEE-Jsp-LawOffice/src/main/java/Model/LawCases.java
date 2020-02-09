package Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class LawCases {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String court;
    private String regNumber;
    private String time;
    private Date date;
    private String client;
    private String against;
    private String courtRoom;
    private String aditionalInfo;

    private String byUser;

    public LawCases(String court,String regNumber, String time, Date date, String client, String against, String courtRoom,
                    String aditionalInfo) {
        this.regNumber = regNumber;
        this.time = time;
        this.date = date;
        this.client = client;
        this.against = against;
        this.courtRoom = courtRoom;
        this.aditionalInfo = aditionalInfo;
        this.court = court;

    }

    public LawCases(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public String getCourtRoom() {
        return courtRoom;
    }

    public void setCourtRoom(String courtRoom) {
        this.courtRoom = courtRoom;
    }

    public String getAditionalInfo() {
        return aditionalInfo;
    }

    public void setAditionalInfo(String aditionalInfo) {
        this.aditionalInfo = aditionalInfo;
    }

    public String getByUser() {
        return byUser;
    }

    public void setByUser(String byUser) {
        this.byUser = byUser;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getAgainst() {
        return against;
    }

    public void setAgainst(String against) {
        this.against = against;
    }

    @Override
    public String toString() {
        return "LawCases{" +
                "id=" + id +
                ", court='" + court + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", time='" + time + '\'' +
                ", date=" + date +
                ", client='" + client + '\'' +
                ", against='" + against + '\'' +
                ", courtRoom='" + courtRoom + '\'' +
                ", aditionalInfo='" + aditionalInfo + '\'' +
                ", byUser='" + byUser + '\'' +
                '}';
    }
}
