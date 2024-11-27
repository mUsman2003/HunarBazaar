package strategy;

public class homepagecontext {
    private homepagestrategy homePageStrategy;

    public void setHomePageStrategy(homepagestrategy homePageStrategy) {
        this.homePageStrategy = homePageStrategy;
    }

    public void displayHomePage() {
        if (homePageStrategy != null) {
            homePageStrategy.displayHomePage();
        } else {
            System.out.println("No strategy set!");
        }
    }
}
