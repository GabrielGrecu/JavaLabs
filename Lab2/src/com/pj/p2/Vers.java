package com.pj.p2;

class Vers {
    private String vers;

    public Vers(String vers) {
        this.vers = vers;
    }

    public int numarCuvinte() {
        String[] cuvinte = vers.split("\\s+");
        return cuvinte.length;
    }

    public int numarVocale() {
        int numarVocale = 0;
        for (char c : vers.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                numarVocale++;
            }
        }
        return numarVocale;
    }

    public String getVers() {
        return vers;
    }
}
