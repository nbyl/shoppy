class supervisord-base {
  package{ 'curl':
    ensure => installed
  }

  class { 'supervisord':
    install_pip           => true,
    inet_server           => true,
    inet_server_hostname  => '*',
    require               => Package['curl']
  }
}
