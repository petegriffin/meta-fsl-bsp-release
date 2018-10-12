DESCRIPTION = "A library to retrieve i.MX GPU performance data"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=5ab1a30d0cd181e3408077727ea5a2db"

SRC_URI[arm-fb.md5sum] = "e7010ac92ae51d187ae587610ca3659d"
SRC_URI[arm-fb.sha256sum] = "8bd4ef0b766100208a65cd6241f17cf25aea04f6eef66629ef8b4f2d3bba6e38"

SRC_URI[arm-wayland.md5sum] = "db24959984194a4fd7fffb2eec6b129f"
SRC_URI[arm-wayland.sha256sum] = "4789d1f99042d5b6fa80587df8d59f6c3562aa226bdc1ec9df51cd9b3ca6f7f7"

SRC_URI[arm-x11.md5sum] = "13ae08364a7d0215b03461558b157b51"
SRC_URI[arm-x11.sha256sum] = "94ef156f90a608ea8646a1b5279ea40c9319d6f8559b0572895187dc9a2c0c8d"

SRC_URI[aarch64-fb.md5sum] = "0dad892e40c36169e2b492b5cae546b1"
SRC_URI[aarch64-fb.sha256sum] = "cf31a4cd568411f95053796817c64ee535344835de7572aee7bf6e14ff7d1f85"

SRC_URI[aarch64-wayland.md5sum] = "c3babacd5daa3072d8efe92a4f93f084"
SRC_URI[aarch64-wayland.sha256sum] = "f09bb8741d31657bb7550ffda6135fc1bbe71f1d6f9e599616d61f011ab0466a"

SRC_URI[aarch64-x11.md5sum] = "a4dae1d0c012f499a2b66b9ccb972329"
SRC_URI[aarch64-x11.sha256sum] = "0013cf7312d72b68221a447852c23e56685a5c3ba28906176c41edeb1247711f"

inherit fsl-eula-unpack2 fsl-eula-graphics

PACKAGE_ARCH = "${MACHINE_SOCARCH}"

RDEPENDS_${PN} = "imx-gpu-viv"

# Compatible only with i.MX with GPU
COMPATIBLE_MACHINE        = "(^$)"
COMPATIBLE_MACHINE_imxgpu = "${MACHINE}"
