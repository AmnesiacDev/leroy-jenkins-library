def call(String container_name){
  def container = sh (
    script: "docker ps -q --filter name=^/${container_name}\$",
    returnStdout: true
    ).trim()
  return !container.isEmpty()
}
