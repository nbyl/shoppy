class tzdata {
  package {'tzdata':
    ensure  => 'present'
  }

  file {'/etc/localtime':
    require => Package['tzdata'],
    source  => 'file:///usr/share/zoneinfo/Europe/Berlin',
  }

  file {'/etc/timezone':
    content => 'Europe/Berlin',
  }
}
