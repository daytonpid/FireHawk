DESCRIPTION = "FireNodejs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://firenodejs-start.sh"

inherit update-rc.d

INITSCRIPT_NAME = "firenodejs-start"
INITSCRIPT_PARAMS = "start 99 S ."

do_install () {
        install -d ${D}${sysconfdir}/init.d/
        install -m 0755 ${WORKDIR}/firenodejs-start.sh ${D}${sysconfdir}/init.d/
}
