package PRO2;


public class FactoryListPanel extends ListPanel {
    public void addFactoryPanel(FactoryPanel factoryPanel) {
        addPanel(factoryPanel);
    }

    public void removeFactoryPanel(FactoryPanel factoryPanel) {
        removePanel(factoryPanel);
    }
}
