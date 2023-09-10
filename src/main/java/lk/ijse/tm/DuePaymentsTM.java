package lk.ijse.tm;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DuePaymentsTM {
    private String studentId;
    private String studentName;
    private String address;
    private String contactNo;
    private Double keyMoney;
    private String resId;
    private String roomId;

    public DuePaymentsTM(){}
}
