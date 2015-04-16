define shoppy-service ($serviceName) {
  include java8
  include supervisord-base

  file{ "/opt/shoppy":
    ensure => directory
  }

  file{ "/opt/shoppy/$serviceName":
    ensure  => directory,
    recurse => remote,
    source  => "/vagrant/$serviceName-service/build/install/$serviceName-service",
    require => File["/opt/shoppy"]
  }

  supervisord::program { "$serviceName-service":
    command     => "/opt/shoppy/$serviceName/bin/$serviceName-service",
    directory   => "/opt/shoppy",
    autostart   => true,
    autorestart => true,
    user        => "vagrant",
    environment => {
      "HOME"  => "/home/vagrant"
    },
    require     => File["/opt/shoppy/$serviceName"]
  }
}
