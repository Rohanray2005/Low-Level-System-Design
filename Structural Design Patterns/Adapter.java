// Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate.

public interface AnalyticsInterface {
    Data returnData(XmlData xmlData);
}

public class Analytics implements AnalyticsInterface {
    public Data returnData(XmlData xmlData) {
        // processing
        return new Data();
    }
}

public class AdvanceAnalytics {
    public Data returnData(JsonData JsonData) {
        // advance processing 
        return new Data();
    }
}

// but we have xml data coming from all our sources and we still need advance analytics

public class AnalyticsAdapter implements Analytics {
    private AdvanceAnalytics advanceAnalytics;

    public AnalyticsAdapter(){
        this.advanceAnalytics = new AdvanceAnalytics();
    }

    @Override
    public Data returnData(XmlData xmlData) {
        JsonData jsonData = convertXmlToJson(xmlData);
        return advanceAnalytics.returnData(jsonData);
    }

    private JsonData convertXmlToJson(XmlData xmlData){
        return convertInternalToJson(xmlData);
    }
}


// use - client
AnalyticsAdapter adapter = new AnalyticsAdapter();
adapter.returnData(xmlData);