class shoppy-service::base {
  file{ "/opt/shoppy":
    ensure => directory
  }

  file{ "/opt/shoppy/bin":
    ensure  => directory,
    require => File["/opt/shoppy"]
  }

  file{ "/opt/shoppy/config":
    ensure  => directory,
    recurse => remote,
    source  => "/vagrant/vagrant/config",
    require => File["/opt/shoppy"]
  }

  file{ "/opt/shoppy/services":
    ensure  => directory,
    require => File["/opt/shoppy"]
  }
}

define shoppy-service (
    $serviceName,
    $waitForRegistry      = false,
    $waitForConfigServer  = false
  ) {

  include java8
  include supervisord-base

  include shoppy-service::base

  file{ "/opt/shoppy/services/$serviceName":
    ensure  => directory,
    recurse => remote,
    source  => "/vagrant/$serviceName-service/build/install/$serviceName-service",
    require => File["/opt/shoppy/services"]
  }

  file{ "/opt/shoppy/bin/$serviceName":
    ensure  => present,
    mode    => '0755',
    content => template("shoppy-service/start-script.erb")
  }

  supervisord::program { "$serviceName-service":
    command     => "/opt/shoppy/bin/$serviceName",
    directory   => "/opt/shoppy",
    autostart   => true,
    autorestart => true,
    user        => "vagrant",
    environment => {
      "HOME"  => "/home/vagrant"
    },
    require     => [File["/opt/shoppy/services/$serviceName"], File["/opt/shoppy/bin/$serviceName"], File["/opt/shoppy/config"]]
  }
}
