package soa.lab2.ex2.models;

public enum BeerCompany {
  TYSKIE ("Tyskie Lane"),
  LECH_FREE("Lech Non Alcohol"),
  KSIAZECE_WHEAT ("Ksiazece Pszeniczne"),
  KSIAZECE_DARK ("Ksiazece Ciemne"),
  GRODZISKA_IPA ("Grodziska Ipa"),
  CACTUS_JUICE ("Pyszniutki soczek z kaktusa");

  private final String name;

  private BeerCompany(String s) {
    name = s;
  }

  public boolean equalsName(String otherName) {
    // (otherName == null) check is not needed because name.equals(null) returns false
    return name.equals(otherName);
  }

  public String toString() {
    return this.name;
  }
}
