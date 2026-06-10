# A simple 'Hello, world' recipe for Yocto (>= 5.3)
DESCRIPTION = "Simple Hello, world demo recipe"
SECTION = "examples"
HOMEPAGE = ""
LICENSE = "MIT"
LIC_FILES_CHKSUM = "\
	file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
	"
# Fill Runtime DEPENDencieS - the RDEPENDS value - for this recipe's package;
# (Note- honister 3.4 onwards, the syntax is of the form x:y not x_y !
# f.e. = "bash dpkg python"
RDEPENDS:${PN} = ""

# Location of files
#  Tip: append ';unpack=0 \' to not unpack the file
SRC_URI = " file://helloworld.c \
   "

# The FILE_${PN} addition below is required to avoid the 'installed but not
# shipped in any package' error; it's left commented out by default
# (Note- honister 3.4 onwards, the syntax is of the form x:y not x_y !
#FILES:${PN} += "${base_prefix}/ helloworld.c \"

IMAGE_FEATURES += ""

# NOTE !!!
# From Yocto 5.3, pl change the variable WORKDIR to UNPACKDIR
S = "${UNPACKDIR}"
do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# Specify compilation commands here
	${CC} ${CFLAGS} ${LDFLAGS} ${UNPACKDIR}/helloworld.c -o ${UNPACKDIR}/helloworld
}

do_install () {
	# Specify install commands here
	install -d -m 0755 ${D}/${bindir}
	install -m 0755 ${UNPACKDIR}/helloworld ${D}/${bindir}
		# $bindir = /usr/bin/
}
