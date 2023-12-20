package dev.footer.tetrajs.kjs;

import dev.footer.tetrajs.kjs.registry.TetraRegistryEvent;
import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventHandler;

public class Plugin extends KubeJSPlugin {

    public static final EventGroup TETRAJS = EventGroup.of("TetraEvents");
    public static final EventHandler REGISTRY = TETRAJS.startup("registry", () -> TetraRegistryEvent.class);

    @Override
    public void registerEvents() {
        TETRAJS.register();
    }
}
