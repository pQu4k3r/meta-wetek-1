<<<<<<< HEAD
SUMMARY = "Wetek mali driver for ${MACHINE}"
=======
SUMMARY = "Wetek Mali Video driver for ${MACHINE}"
>>>>>>> 5c0998b6caba9ebccf997d9d143f18ade80754a6
SECTION = "base"
PRIORITY = "required"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Makefile;md5=d0d2f45bce10dd67cca4a749d12e535e"

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(wetekplay2|wetekhub)$"

SRC_URI[md5sum] = "b849349480679ca6253cf2660e366ec6"

SRC_URI = "http://sources.libreelec.tv/devel/gpu-aml-r6p1-01rel0-2364187.tar.xz"

S = "${WORKDIR}/gpu-aml-r6p1-01rel0-2364187/mali"

inherit module

EXTRA_OEMAKE = "CONFIG_MALI400=m CONFIG_MALI450=m KDIR=${STAGING_KERNEL_BUILDDIR}"

do_compile() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake -C "${STAGING_KERNEL_BUILDDIR}" M="${S}" modules
}

do_install() {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/drivers/gpu/mali
	install -m 0644 ${S}/mali.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/drivers/gpu/mali
}
