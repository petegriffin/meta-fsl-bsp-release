WAYLAND_PROTOCOLS_SRC ?= "git://source.codeaurora.org/external/imx/wayland-protocols-imx.git;protocol=https"
SRCBRANCH = "master"
SRC_URI = "${WAYLAND_PROTOCOLS_SRC};branch=${SRCBRANCH} "
SRCREV = "522fa921c4590da689ee7005e42d4d663190fecf"
S = "${WORKDIR}/git"