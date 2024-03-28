package com.pj.p4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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

    /**
     * ca si in curs pag 41
     *
     * @return
     */
    public int getAge() {
        int birthYear = Integer.parseInt(cnp.substring(1, 3));
        int birthMonth = Integer.parseInt(cnp.substring(3, 5));

        LocalDate birthDate;

        int currentYear = LocalDate.now().getYear() % 100;
        if (birthYear > currentYear) {
            birthYear += 1900;
            birthDate = LocalDate.of(birthYear, birthMonth, 1);
        } else {
            birthYear += 2000;
            birthDate = LocalDate.of(birthYear, birthMonth, 1);
        }

        LocalDate currentDate = LocalDate.now();

        long years = ChronoUnit.YEARS.between(birthDate, currentDate);

        return (int) years;
    }
}