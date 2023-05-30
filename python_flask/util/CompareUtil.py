import difflib
import filecmp
import sys


def dir_compare(dir1, dir2):
    diff = filecmp.dircmp(dir1, dir2)
    result = {
        'common': diff.common,
        'dir2_only': diff.right_only,
        'dir1_only': diff.left_only,
        'dir2': diff.right_list,
        'dir1': diff.left_list,
    }
    return result


def read_file_lines(filename):
    try:
        df = open(filename, "rb")
        text = [line.decode() for line in df.read().splitlines()]
        df.close()
        return text
    except Exception:
        return None


def file_compare(file1, file2):
    file1_lines = read_file_lines(file1)
    file2_lines = read_file_lines(file2)
    diff = difflib.HtmlDiff()
    return diff.make_file(file1_lines, file2_lines)
