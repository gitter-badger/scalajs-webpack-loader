package io.kjaer.scalajs.webpack

import coursier.cache.CacheLogger

class WebpackCacheLogger(logger: WebpackLogger) extends CacheLogger {
  override def downloadingArtifact(url: String): Unit =
    logger.info("Downloading artifact " + url)

  override def downloadedArtifact(url: String, success: Boolean): Unit =
    if (success) logger.info("Downloaded " + url)
    else logger.error("Failed to download " + url)

  override def foundLocally(url: String): Unit =
    logger.debug("Found locally " + url)
}
