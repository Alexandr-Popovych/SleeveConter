package services;

import pipedetails.Fitting;
import pipedetails.Sleeve;

import java.util.List;

public class SleeveCounting {
    private SleeveCounting() {
    }

    public static Sleeve countSleeves(List<Fitting> fittings) {
        Sleeve sleeve = new Sleeve();
        final String delimiter = "-";

        for (Fitting fitting : fittings) {
            String[] substrings = fitting.getDesignation().split(delimiter);
            for (String substring : substrings) {
                updateSleeveCount(sleeve, substring.trim(), fitting.getQuantity());
            }
        }

        return sleeve;
    }

    private static void updateSleeveCount(Sleeve sleeve, String designation, double quantity) {
        switch (designation) {
            case "16" -> sleeve.setDiameter16(sleeve.getDiameter16() + quantity);
            case "20" -> sleeve.setDiameter20(sleeve.getDiameter20() + quantity);
            case "25" -> sleeve.setDiameter25(sleeve.getDiameter25() + quantity);
            case "32" -> sleeve.setDiameter32(sleeve.getDiameter32() + quantity);
        }
    }
}