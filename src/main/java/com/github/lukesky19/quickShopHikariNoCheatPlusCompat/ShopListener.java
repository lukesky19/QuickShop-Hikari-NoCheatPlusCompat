/*
    * Fix compatibility issues between NoCheatPlus and QuickShop-Hikari when creating shops.
    Copyright (C) 2024  lukeskywlker19

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as published
    by the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/
package com.github.lukesky19.quickShopHikariNoCheatPlusCompat;

import com.ghostchu.quickshop.api.event.ProtectionCheckStatus;
import com.ghostchu.quickshop.api.event.ShopProtectionCheckEvent;
import fr.neatmonster.nocheatplus.hooks.NCPExemptionManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ShopListener implements Listener {
    @EventHandler
    public void onShopCreation(ShopProtectionCheckEvent event) {
        if(event.getStatus() == ProtectionCheckStatus.BEGIN) {
            NCPExemptionManager.exemptPermanently(event.getPlayer().getUniqueId());
        } else if(event.getStatus() == ProtectionCheckStatus.END) {
            NCPExemptionManager.unexempt(event.getPlayer().getUniqueId());
        }
    }

}
