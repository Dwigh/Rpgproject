package de.fansana.FairItemPickup;



import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;



public class ConfigHandler {
    public static ConfigHandler instance;
    
    //Config
    public int freePickUpTime;
    
    private ConfigHandler(FMLPreInitializationEvent event){
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        
        //Config
        
        freePickUpTime = Integer.parseInt(config.getString("itemFreePickUptimer", "MiscConfig", "120", 
                "The time a user has to wait until he can pickup someone elses items in seconds [Min:1] [Max:250]"));
        
        
        config.save();
    }
    public static ConfigHandler getInstance(){
        if(instance != null)
            return instance;
        return null;
            
    }
    public static void Instanciate(FMLPreInitializationEvent event){
        if(instance == null)
            instance = new ConfigHandler(event);
    }
    private int clamp(int number, int min, int max){
        if(number > max)
            return max;
        if(number < min)
            return min;
        return number;
        
    }
}
