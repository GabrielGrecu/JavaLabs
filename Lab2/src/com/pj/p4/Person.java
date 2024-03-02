package com.pj.p4;

import java.time.LocalDate;

class Person {
    private String name;
    private String cnp;

    public Person(String name, String cnp) {
        this.name = name;
        this.cnp = cnp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public int getAge() {
        String birthYearStr = cnp.substring(1, 3);
        int birthYear = Integer.parseInt(birthYearStr);
        int currentYear = LocalDate.now().getYear() % 100;
        if (birthYear <= currentYear) {
            return currentYear - birthYear;
        } else {
            return currentYear - birthYear + 100;
        }
    }
}




//public int getAge() {
//        int birthYear = Integer.parseInt(cnp.substring(1, 3));
//        int birthMonth = Integer.parseInt(cnp.substring(3, 5));
//        int birthDay = Integer.parseInt(cnp.substring(5, 7));
//
//        LocalDate currentDate = LocalDate.now();
//
//        LocalDate birthDate = LocalDate.of(1900 + birthYear, birthMonth, birthDay);
//        int age = Period.between(birthDate, currentDate).getYears();
//
//        if (currentDate.getMonthValue() < birthMonth || (currentDate.getMonthValue() == birthMonth && currentDate.getDayOfMonth() < birthDay)) {
//            age--;
//        }
//
//        return age;
//    }