package ju.com.mybookstaff.FirstPage;

public class OfferModel {
    private String bookName,bookPrice,bookPhoto,fromName,toName,fromPhone,toPhone,date,time,place;

    public OfferModel(){}
    public OfferModel(String bookName, String bookPrice, String bookPhoto, String fromName, String toName, String fromPhone, String toPhone, String date, String time, String place) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookPhoto = bookPhoto;
        this.fromName = fromName;
        this.toName = toName;
        this.fromPhone = fromPhone;
        this.toPhone = toPhone;
        this.date = date;
        this.time = time;
        this.place = place;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookPhoto() {
        return bookPhoto;
    }

    public void setBookPhoto(String bookPhoto) {
        this.bookPhoto = bookPhoto;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getFromPhone() {
        return fromPhone;
    }

    public void setFromPhone(String fromPhone) {
        this.fromPhone = fromPhone;
    }

    public String getToPhone() {
        return toPhone;
    }

    public void setToPhone(String toPhone) {
        this.toPhone = toPhone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

}
