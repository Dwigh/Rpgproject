
package de.fansana.FairItemPickup.EventHooks;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import de.fansana.FairItemPickup.ConfigHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;


public class EventHookContainerClass {
    
    @SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=false)
    public void onEvent(EntityItemPickupEvent event){
        String name;
        if(event.item.getEntityData().hasKey("player")){
            name = event.item.getEntityData().getString("player");
            if(!event.entityPlayer.getDisplayName().equals(name))
                if(event.item.ticksExisted > ConfigHandler.getInstance().freePickUpTime*20){
                } else {
                    if(event.isCancelable())
                    event.setCanceled(true); 
                }
        }
    }
    
    @SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=false)
    public void onEvent(ItemTossEvent event){
        String name = event.player.getDisplayName(); //FIXME: Displayname is not acurate.
        if(!event.player.isSneaking())
        event.entityItem.getEntityData().setString("player", name);
    }
    
    @SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=false)
    public void onEvent(LivingDropsEvent event){
        if(event.source.getEntity() instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer)event.source.getEntity();
            for(Entity entity : event.drops){
                entity.getEntityData().setString("player", player.getDisplayName());
            }
        }
    }
    @SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=false)
    public void onEvent(UseHoeEvent event){
        double speed = event.entityPlayer.capabilities.getWalkSpeed();
        event.entityPlayer.setHealth(100F);
    }
    
    
}
