def call(String service_name){
  sh """
        docker compose up -d "${service_name}"
    """
}
