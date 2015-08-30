package me.MageProtocol.Shutters.common.util;

import me.MageProtocol.Shutters.common.config.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Z on 30/08/2015.
 */
public final class LogHelper
{
    private static Logger logger = LogManager.getLogger(Reference.MODID);

    public static void log(org.apache.logging.log4j.Level level, String msg)
    {
        logger.log(level, msg);
    }

    public static void info(String msg)
    {
        logger.info(msg);
    }

    public static void warn(String msg)
    {
        logger.warn(msg);
    }

    public static void fatal(String msg)
    {
        logger.fatal(msg);
    }

    public static void debug(String msg)
    {
        if (Config.logDebug)
        {
            logger.info(msg);
        }
    }

    public static void logCatch(org.apache.logging.log4j.Level lvl, Throwable throwable)
    {
        logger.catching(lvl, throwable);
    }
}
