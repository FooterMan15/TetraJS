package dev.footer.tetrajs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
@Mod("tetrajs")
public class TetraJSRoot {

    private static final Logger LOGGER = LogManager.getLogger();

    public TetraJSRoot() {
        LOGGER.info("Loading TetraJS...");
        IEventBus MOD_BUS = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
    }
}
