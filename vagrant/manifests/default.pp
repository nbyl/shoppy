include tzdata

shoppy-service{ "registry":
  serviceName => "registry"
}

shoppy-service{ "config":
  serviceName     => "config",
  waitForRegistry => true
}
