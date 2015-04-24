# -*- mode: ruby -*-
# vi: set ft=ruby :

# Vagrantfile API/syntax version. Don't touch unless you know what you're doing!
VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  config.vm.box = "ubuntu/trusty64"

  # Create a private network, which allows host-only access to the machine
  # using a specific IP.
  config.vm.network "private_network", ip: "192.168.33.10"

  config.vm.provider "virtualbox" do |vb|
  #   # Don't boot with headless mode
  #   vb.gui = true
    vb.cpus = 4
    vb.customize ["modifyvm", :id, "--ioapic", "on"]
    vb.customize ["modifyvm", :id, "--memory", "4096"]
  end

  # add this hostname to the host system
  config.vm.hostname = "shoppy.dev"
  config.hostmanager.enabled = true
  config.hostmanager.manage_host = true

  config.vm.provision :shell do |shell|
    shell.inline = "mkdir -p /etc/puppet/modules;
                    if ! `puppet module list | grep -q java8`; then puppet module install spantree-java8; fi;
                    if ! `puppet module list | grep -q supervisor`; then puppet module install ajcrowe-supervisord; fi;
                    if ! `puppet module list | grep -q mailcatcher`; then puppet module install actionjack-mailcatcher; fi;
                    if ! `puppet module list | grep -q nginx`; then puppet module install jfryman-nginx; fi;
                    "
  end

  config.vm.provision "puppet" do |puppet|
    puppet.manifests_path = "vagrant/manifests"
    puppet.module_path = "vagrant/modules"
  end
end
