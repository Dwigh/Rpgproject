package de.fansana.FairItemPickup;



import de.fansana.FairItemPickup.EventHooks.EventHookContainerClass;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import de.fansana.FairItemPickup.Proxies.FairItemPickupProxy;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;



@Mod(modid = FairItemPickup.MODID, version= FairItemPickup.VERSION, acceptableRemoteVersions = "*")
public class FairItemPickup {
    public static final String MODID = "fairitempickup";
    public static final String VERSION = "1.1.0";
    
    @Instance(value="FairItemPickup")
    public static FairItemPickup instance;
    
    @SidedProxy(clientSide="de.fansana.FairItemPickup.Proxies.FairItemPickupClientProxy", serverSide="de.fansana.FairItemPickup.Proxies.FairItemPickupProxy")
    public static FairItemPickupProxy proxy;
    
    
    //COnfig einlesen, sonstiges runterladen, Updates
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        ConfigHandler.Instanciate(event);
    }
    
    //lad die Mod selbst
    @EventHandler
    public void load(FMLInitializationEvent event){
        proxy.registerRenderers();
        Minecraft.getMinecraft().ingameGUI = new HealthGui(Minecraft.getMinecraft());
        MinecraftForge.EVENT_BUS.register(new EventHookContainerClass()); 
    }

    
    // für submods und stuff
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        
    }
    
}
