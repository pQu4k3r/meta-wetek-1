SUMMARY = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(wetekplay)$"

SRCDATE = "20160420"

PV = "${KV}+${SRCDATE}"

RDEPENDS_${PN} += "wetek-e2-procfs-${MACHINE} firmware-avl6211 firmware-mn88436 firmware-ap6210 firmware-dvb-usb-af9015"

SRC_URI = "file://wetek-dvb-modules-${KV}-${SRCDATE}.zip"

S = "${WORKDIR}"

do_compile() {
}

do_install() {
	install -d ${D}${nonarch_base_libdir}/modules/${KV}/extra
	install -d ${D}${sysconfdir}/modules-load.d
	echo "wetekdvb" > ${D}${sysconfdir}/modules-load.d/_${MACHINE}.conf
	install -m 0755 ${WORKDIR}/wetekdvb.ko ${D}${nonarch_base_libdir}/modules/${KV}/extra/
}

FILES_${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf ${nonarch_base_libdir}/modules/${KV}/extra"

do_package_qa() {
}
