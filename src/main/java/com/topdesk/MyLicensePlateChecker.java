package com.topdesk;

import java.util.regex.Pattern;

public class MyLicensePlateChecker implements ILicensePlateChecker {

    private LicensePlateSpecification licensePlateSpecification;

    private static final Pattern LETTERS_PATTERN = Pattern.compile("^[A-Z]+$");
    private static final Pattern DIGITS_PATTERN  = Pattern.compile("^\\d+$");

    @Override
    public void setSpecification(LicensePlateSpecification specification) {
    	this.licensePlateSpecification = specification;
    }

    @Override
    public boolean isValid(LicensePlate licensePlate) {
    	if (licensePlateSpecification == null || licensePlate == null ){
            return false;
        }

        return isTownCodeValid(licensePlate.getTownCode())
                && isLetterSequenceValid(licensePlate.getLetterSequence())
                && isDigitSequenceValid(licensePlate.getDigitSequence())
                && isTotalLengthValid(licensePlate);
    }


    private boolean isTownCodeValid(String townCode){

        return townCode !=null && licensePlateSpecification.getValidTownCodes().contains(townCode);

    }


    private boolean isLetterSequenceValid(String letterSequence) {
        return letterSequence !=null
                && LETTERS_PATTERN.matcher(letterSequence).matches()
                && letterSequence.length() >= licensePlateSpecification.getMinNumLetters();
    }


    private boolean isDigitSequenceValid(String digitSequence) {
        return  digitSequence != null
                && DIGITS_PATTERN.matcher(digitSequence).matches()
                && digitSequence.length() >= licensePlateSpecification.getMinNumDigits();
    }


    private boolean isTotalLengthValid(LicensePlate licensePlate) {
        int totalLength =  safeLength(licensePlate.getTownCode()) +
                safeLength(licensePlate.getLetterSequence()) +
                safeLength(licensePlate.getDigitSequence());

        return totalLength == licensePlateSpecification.getTotalLength();
    }

    private int safeLength(String str) {
        return str == null ? 0 : str.length();
    }
}
