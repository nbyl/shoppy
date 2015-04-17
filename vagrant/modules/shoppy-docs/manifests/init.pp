class shoppy-docs {
  class { "nginx": }

  file{ "/srv/shoppy-docs":
    ensure  => directory,
    recurse => remote,
    source  => "/vagrant/shoppy-docs"
  }

  nginx::resource::vhost { 'shoppy.dev':
    www_root => "/srv/shoppy-docs",
  }
}
