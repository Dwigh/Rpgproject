/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fansana.FairItemPickup.Proxies;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;


/**
 *
 * @author fansana
 */
public class FairItemPickupProxy {
    public ISimpleBlockRenderingHandler renderer;
    public int rendererId; 
    public void registerRenderers(){
        //rendererId = RenderingRegistry.getNextAvailableRenderId();
        //renderer = new MyRenderer(rendererId);
        //RenderingRegistry.registerBlockHandler();
    }
}
