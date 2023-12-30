package dev.footer.tetrajs.kjs;

import dev.latvian.mods.kubejs.event.*;

public interface TetraEvents {
    EventGroup GROUP = EventGroup.of("TetraEvents");

    EventHandler REGISTRY = GROUP.startup("registry", () -> StartupEventJS.class);
}
