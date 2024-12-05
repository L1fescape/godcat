package com.l1fescape.minecraft;

import org.bukkit.attribute.Attribute;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.entity.LivingEntity;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.Set;

public class CatGodMode implements Listener {
  @EventHandler
  public void onDamageEvent(EntityDamageEvent e) {
    Entity entity = e.getEntity();
    String entityName = entity.getName();
    if (entityName != null && entityName.equals("Cat")) {
      Bukkit.getServer().getLogger().info(String.format("Damage event blocked for %s", entityName));  
      e.setCancelled(true);
      LivingEntity livingCat = (LivingEntity) entity;
      livingCat.setHealth(livingCat.getAttribute(Attribute.MAX_HEALTH).getValue());
    }
  }
}
