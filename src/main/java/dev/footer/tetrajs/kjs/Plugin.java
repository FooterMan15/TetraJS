package dev.footer.tetrajs.kjs;


import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.ScriptType;

public class Plugin extends KubeJSPlugin {

    @Override
    public void registerEvents() {
        TetraEvents.GROUP.register();
    }
}