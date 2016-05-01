SUMMARY = "A console development image with some C/C++ dev tools"
HOMEPAGE = "http://www.jumpnowtek.com"
LICENSE = "MIT"

IMAGE_FEATURES += "package-management splash"
IMAGE_LINGUAS = "en-us"

inherit core-image

DEPENDS += "bcm2835-bootfiles"

CORE_OS = " \
    openssh openssh-keygen openssh-sftp-server \
    term-prompt \
    tzdata \
 "

WIFI_SUPPORT = " \
    iw \
    linux-firmware-brcm43430 \
    linux-firmware-ralink \
    linux-firmware-rtl8192ce \
    linux-firmware-rtl8192cu \
    linux-firmware-rtl8192su \
    wireless-tools \
    wpa-supplicant \
 "

DEV_SDK_INSTALL = " \
    binutils \
    binutils-symlinks \
    coreutils \
    cpp \
    cpp-symlinks \
    diffutils \
    file \
    gcc \
    gcc-symlinks \
    g++ \
    g++-symlinks \
    gettext \
    git \
    ldd \
    libstdc++ \
    libstdc++-dev \
    libtool \
    make \
    perl-modules \
    pkgconfig \
    python-modules \
 "

DEV_EXTRAS = " \
    ntp \
    ntp-tickadj \
    serialecho \
    spiloop \
    zeromq \
    zeromq-dev \
 "

EXTRA_TOOLS_INSTALL = " \
    bc \
    bzip2 \
    devmem2 \
    dosfstools \
    ethtool \
    findutils \
    i2c-tools \
    iftop \
    iperf \
    htop \
    less \
    nano \
    procps \
    rsync \
    sysfsutils \
    tcpdump \
    unzip \
    util-linux \
    vim-tiny \
    wget \
    zip \
 "

RPI_STUFF = " \
    bcm2835-tests \
    rpio \
    rpi-gpio \
    pi-blaster \
    userland \
 "

IMAGE_INSTALL += " \
    ${CORE_OS} \
    ${DEV_SDK_INSTALL} \
    ${DEV_EXTRAS} \
    ${EXTRA_TOOLS_INSTALL} \
    ${RPI_STUFF} \
    ${WIFI_SUPPORT} \
 "

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/EST5EDT ${IMAGE_ROOTFS}/etc/localtime
}

disable_bootlogd() {
    echo BOOTLOGD_ENABLE=no > ${IMAGE_ROOTFS}/etc/default/bootlogd
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
    disable_bootlogd ; \
 "

export IMAGE_BASENAME = "console-image"
