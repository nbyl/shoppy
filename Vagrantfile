# -*- mode: ruby -*-
# vi: set ft=ruby :

# Vagrantfile API/syntax version. Don't touch unless you know what you're doing!
VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  config.vm.box = "ubuntu/trusty64"

  # The url from where the 'config.vm.box' box will be fetched if it
  # doesn't already exist on the user's system.
  config.vm.box_url = "http://files.vagrantup.com/trusty64.box"

  # Create a private network, which allows host-only access to the machine
  # using a specific IP.
  config.vm.network "private_network", ip: "192.168.33.10"

  config.vm.provider "virtualbox" do |vb|
  #   # Don't boot with headless mode
  #   vb.gui = true
    vb.cpus = 4
    vb.customize ["modifyvm", :id, "--ioapic", "on"]
    vb.customize ["modifyvm", :id, "--memory", "1024"]
  end

  # add this hostname to the host system
  config.vm.hostname = "shoppy.dev"
  config.hostmanager.enabled = true
  config.hostmanager.manage_host = true

  config.vm.provision "puppet" do |puppet|
    puppet.manifests_path = "vagrant/manifests"
    puppet.manifest_file  = "default.pp"
  end
end
