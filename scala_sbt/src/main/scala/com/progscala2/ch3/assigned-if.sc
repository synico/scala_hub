import java.io.File

val configFile = new File("/home/nick/data/resources.tar.gz")

val configFilePath = if (configFile.exists()) {
  configFile.getAbsolutePath
} else {
  configFile.createNewFile()
  configFile.getAbsolutePath
}