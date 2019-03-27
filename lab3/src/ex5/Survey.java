package ex5;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


@SessionScoped
@ManagedBean(name = "survey")
public class Survey {

    private String name;
    private String email;
    private Integer age;
    private String gender;
    private String education;
    private Integer height;
    //for women
    private String breast;
    private String bra;
    private String waistline;
    private String hips;
    //for men
    private String chest;
    private String midsection ;
    //additional questions
    private String monthlyMoney;
    private String howOften;
    private String preferedColor;

    private Integer numberOfClicks=0;
    private List<String> typeClothes;
    private List<String> typeClothesFeMale=new LinkedList<String>(Arrays.asList("dress","skirt", "jacket"));

    private List<String> typeClothesMale=new LinkedList<>(Arrays.asList("trousers","suit","tie"));
    public void setNumberOfClicks(Integer numberOfClicks) {
        this.numberOfClicks = numberOfClicks;
    }

    public Integer getNumberOfClicks() {
        return numberOfClicks;
    }

    public List<String> getTypeClothes() {
        return typeClothes;
    }

    public List<String> getTypeClothesMale() {
        return typeClothesMale;
    }

    public void setTypeClothes(List<String> typeClothes) {
        this.typeClothes = typeClothes;
    }

    public void setTypeClothesMale(List<String> typeClothesMale) {
        this.typeClothesMale = typeClothesMale;
    }

    public void setTypeClothesFeMale(List<String> typeClothesFeMale) {
        this.typeClothesFeMale = typeClothesFeMale;
    }

    public List<String> getTypeClothesFeMale() {
        return typeClothesFeMale;
    }

    public void setMonthlyMoney(String monthlyMoney) {
        this.monthlyMoney = monthlyMoney;
    }

    public void setHowOften(String howOften) {
        this.howOften = howOften;
    }

    public void setPreferedColor(String preferedColor) {
        this.preferedColor = preferedColor;
    }

    public String getMonthlyMoney() {
        return monthlyMoney;
    }

    public String getHowOften() {
        return howOften;
    }

    public String getPreferedColor() {
        return preferedColor;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getEducation() {
        return education;
    }

    public Integer getHeight() {
        return height;
    }

    public String getBreast() {
        return breast;
    }

    public String getBra() {
        return bra;
    }

    public String getWaistline() {
        return waistline;
    }

    public String getHips() {
        return hips;
    }

    public String getChest() {
        return chest;
    }

    public String getMidsection() {
        return midsection;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setBreast(String breast) {
        this.breast = breast;
    }

    public void setBra(String bra) {
        this.bra = bra;
    }

    public void setWaistline(String waistline) {
        this.waistline = waistline;
    }

    public void setHips(String hips) {
        this.hips = hips;
    }

    public void setChest(String chest) {
        this.chest = chest;
    }

    public void setMidsection(String midsection) {
        this.midsection = midsection;
    }
    public String getImageId () {
        int nb = (int)(Math.random()* ((400 - 100)+400));
        return Integer.toString(nb);
    }

    public void incrementClick(){
        this.numberOfClicks++;
    }
}
