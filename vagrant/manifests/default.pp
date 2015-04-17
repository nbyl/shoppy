class{ "tzdata":
}

package{ "g++":
  ensure => installed
}

class{ "mailcatcher":
  require => Package["g++"]
}

shoppy-service{ "registry":
  serviceName => "registry"
}

shoppy-service{ "config":
  serviceName     => "config",
  waitForRegistry => true
}

shoppy-service{ "edge":
  serviceName         => "edge",
  waitForConfigServer => true
}

shoppy-service{ "email":
  serviceName         => "email",
  waitForConfigServer => true,
  require             => Class["mailcatcher"]
}

shoppy-service{ "frontend":
  serviceName         => "frontend",
  waitForConfigServer => true
}

shoppy-service{ "shoppinglist":
  serviceName         => "shoppinglist",
  waitForConfigServer => true
}

class{ "shoppy-docs":
}
